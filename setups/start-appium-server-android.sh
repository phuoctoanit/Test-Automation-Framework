#!/bin/bash

AVD_NAME="Medium_Phone_API_36.0"
PORT=4725
APPIUM_LOG_DIR="./logs"
LOG_FILE="$APPIUM_LOG_DIR/android-appium-log-$(date +%Y%m%d-%H%M%S).log"

# Create logs folder if it doesn't exist
mkdir -p "$APPIUM_LOG_DIR"

echo "🔍 Checking ADB devices..."
adb start-server
DEVICE_LIST=$(adb devices | grep -w "device")

#Check if any devices are connected
if [ -z "$DEVICE_LIST" ]; then
  echo "⚠️  No connected Android device found. Attempting to start emulator: $AVD_NAME"
  nohup emulator -avd "$AVD_NAME" > /dev/null 2>&1 &

  echo "⏳ Waiting for emulator to start..."
  boot_completed="0"
  until [[ "$boot_completed" == "1" ]]; do
    sleep 3
    boot_completed=$(adb shell getprop sys.boot_completed 2>/dev/null | tr -d '\r')
    echo "🕐 Boot status: $boot_completed"
  done

  echo "✅ Emulator $AVD_NAME is ready."
else
  echo "✅ Device connected: $DEVICE_LIST"
fi

PID_ON_PORT=$(lsof -ti tcp:$PORT)

# Check if the port is already in use
if [[ -n "$PID_ON_PORT" ]]; then
  echo "⚠️ Port $PORT is already in use by PID: $PID_ON_PORT"
  echo "🔫 Killing process using port $PORT..."
  kill -9 "$PID_ON_PORT"
  echo "✅ Killed process $PID_ON_PORT"
else
  echo "✅ Port $PORT is free."
fi

# Start Appium
echo "🚀 Starting Appium server on port $PORT..."
appium --port $PORT --base-path /wd/hub --log-level info --session-override --log "$LOG_FILE" &
APPIUM_PID=$!

echo "📄 Appium log file: $LOG_FILE"
echo "🆗 Appium PID: $APPIUM_PID"
