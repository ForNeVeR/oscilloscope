int sensorPin = A0;
int ledPin = 13;

void setup() {
  pinMode(ledPin, OUTPUT);  
  Serial.begin(38400);
}

void loop() {
  Serial.println(analogRead(sensorPin), DEC);
}
