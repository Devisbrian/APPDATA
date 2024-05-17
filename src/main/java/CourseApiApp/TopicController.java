package CourseApiApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class TopicController {
    //service injection annotation.
    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }
    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
       return topicService.getTopic(id);
    }
    @PostMapping("/topics")
        public ResponseEntity<?> addTopic(@RequestBody Topic topic){
            topicService.addTopic(topic);
            return ResponseEntity.status(HttpStatus.OK).body("Topic added successfully");
        }
    @PutMapping("/topics/{id}")
    public ResponseEntity<?> updateTopic(@RequestBody Topic topic,@PathVariable String id){
        topicService.updateTopic(id,topic);
                return ResponseEntity.status(HttpStatus.OK).body(("Topic updated successfully"));

    }
    @DeleteMapping("/topics/{id}")
    public ResponseEntity<?> deleteTopic( @PathVariable String id){
        topicService.deleteTopic(id);
        return ResponseEntity.status(HttpStatus.OK).body(("Topic Deleted successfully"));

    }

    }
