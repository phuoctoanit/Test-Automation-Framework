#!/bin/bash

echo "Starting Selenium Grid setup..."

PORT=4444
# Find process using the port
PID_ON_PORT=$(lsof -ti tcp:$PORT)

if [[ -n "$PID_ON_PORT" ]]; then
  echo "⚠️ Port $PORT is already in use by PID: $PID_ON_PORT"
  echo "🔫 Killing process using port $PORT..."
  kill -9 "$PID_ON_PORT"
  echo "✅ Killed process $PID_ON_PORT"
else
  echo "✅ Port $PORT is free."
fi

# Define the log directory and file
LOG_DIR="./logs"

mkdir -p "$LOG_DIR"  # Ensure the log directory exists

LOG_FILE="selenium-grid-log-$(date +%Y%m%d-%H%M%S).log"

SELENIUM_JAR_PATH="../drivers/selenium-server-4.33.0.jar"
if [[ ! -f "$SELENIUM_JAR_PATH" ]]; then
    echo "❌ Error: Selenium server jar not found at $SELENIUM_JAR_PATH"
    exit 1
fi

java -jar "$SELENIUM_JAR_PATH" standalone --log "$LOG_DIR/$LOG_FILE" &
NODE_PID=$!
sleep 5  # Wait for the server to start
echo "🆗 Selenium Grid Node PID: $NODE_PID"
echo "📄 Selenium Grid log file: $LOG_DIR/$LOG_FILE"

#mkdir -p "$LOG_DIR"
#echo "🔍 Checking for existing Selenium Grid nodes..."
#if pgrep -f "selenium-server" > /dev/null; then
#  echo "⚠️  Existing Selenium Grid nodes found. Stopping them..."
#  pkill -f "selenium-server"
#  sleep 2
#fi
#echo "🚀 Starting Selenium Grid hub..."
#java -jar ../drivers/selenium-server-4.33.0.jar -role hub --log "$LOG_DIR/$LOG_FILE" &
#HUB_PID=$!
#echo "🆗 Selenium Grid Hub PID: $HUB_PID"
#echo "🚀 Starting Selenium Grid node..."
#java -jar ../drivers/selenium-server-4.33.0.jar -role node --hub http://localhost:4444/grid/register --log "$LOG_DIR/$LOG_FILE" &
#NODE_PID=$!
#echo "🆗 Selenium Grid Node PID: $NODE_PID"
#
#echo "📄 Selenium Grid log file: $LOG_DIR/$LOG_FILE"
