#!/bin/bash

PORT=4723
APPIUM_LOG_DIR="./logs"
LOG_FILE="$APPIUM_LOG_DIR/ios-appium-log-$(date +%Y%m%d-%H%M%S).log"

# Create logs folder if it doesn't exist
mkdir -p "$APPIUM_LOG_DIR"
echo "🔍 Checking for connected iOS devices..."
if ! command -v idevice_id &> /dev/null; then
  echo "⚠️  idevice_id command not found. Please install libimobiledevice tools."
  exit 1
fi

# check port availability
PID_ON_PORT=$(lsof -ti tcp:$PORT)

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
