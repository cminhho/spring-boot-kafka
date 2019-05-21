package vn.nvsoft.kafka.rest;

import vn.nvsoft.kafka.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/producer")
public class ProducerController {

  @Autowired
  KafkaTemplate<String, String> kafkaTemplate;


  @Autowired
  private KafkaTemplate<String, Item> itemKafkaTemplate;

  @Value("${soundcommand.topic.name}")
  private String soundcommandTopicName;

  @PostMapping(value = "/sound-command", consumes = {"application/json"}, produces = {
      "application/json"})
  public String sendSoundCommandMessage(@RequestBody String command) {
    kafkaTemplate.send(soundcommandTopicName, command);
    return "Message published successfully";
  }

  @PostMapping(value = "/postItem", consumes = {"application/json"}, produces = {
      "application/json"})
  public String postJsonMessage(@RequestBody Item item) {
    itemKafkaTemplate.send(soundcommandTopicName, new Item(1, "Lenovo", "Laptop"));
    return "Message published successfully";
  }
}
