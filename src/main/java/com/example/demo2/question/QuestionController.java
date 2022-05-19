package com.example.demo2.question;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/questionBank")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/questionTemplates")
    public List<QuestionCreateResDto> getQuestionTemplates() {
        return questionService.getQuestionTemplatesList();
    }

    @PostMapping("/questionTemplates")
    @ResponseBody
    public QuestionCreateResDto postQuestionTemplate(@Valid @RequestBody QuestionCreateDto questionCreateDto) {
        return questionService.createQuestionTemplate(questionCreateDto);
    }

    @DeleteMapping("/questionTemplates")
    public void deleteAllQuestionTemplates() { questionService.deleteAllFinalQuestionsAndQuestionTemplates();}

//    //TODO
//    @DeleteMapping("/questionTemplates/{id}")
//    public void deleteSingleQuestionTemplateAndCorrespondingQuestions(
//            @PathVariable(name = "id") UUID questionTemplateId
//    ){}


    @GetMapping("/finalQuestions")
    public List<FinalQuestionResDto> getFinalQuestions() {
        return questionService.getFinalQuestionsList();
    }

    @GetMapping("/finalQuestions/{topic}")
    public List<FinalQuestionResDto> getFinalQuestionsByTopic(@PathVariable String topic) {
        return questionService.getFinalQuestionsListByTopic(topic);
    }
}
