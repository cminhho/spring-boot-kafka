# Spring Kafka

This is a simple Spring Boot app to demonstrate sending and receiving of messages in Kafka using spring-kafka.

As Kafka topics are not created automatically by default, this application requires that you create the following topics manually.

### Configuring Topics

`$ .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic soundcommand`<br>
`$ .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 5 --topic texttospeed`<br>
`$ .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic filtered`<br>
`$ .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic greeting`<br>

When the application runs successfully, following output is logged on to console (along with spring logs):

### Producing Messages

### Consuming Messages

`$ .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic soundcommand --from-beginning`<br>


