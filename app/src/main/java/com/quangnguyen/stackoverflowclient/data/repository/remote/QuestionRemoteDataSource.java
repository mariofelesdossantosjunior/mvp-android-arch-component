package com.quangnguyen.stackoverflowclient.data.repository.remote;

import com.quangnguyen.stackoverflowclient.data.api.QuestionResponse;
import com.quangnguyen.stackoverflowclient.data.api.QuestionService;
import com.quangnguyen.stackoverflowclient.data.model.Question;
import com.quangnguyen.stackoverflowclient.data.repository.QuestionDataSource;
import io.reactivex.Flowable;
import java.util.List;
import javax.inject.Inject;

/**
 * @author QuangNguyen (quangctkm9207).
 */
public class QuestionRemoteDataSource implements QuestionDataSource {

  private QuestionService questionService;

  @Inject
  public QuestionRemoteDataSource(QuestionService questionService) {
    this.questionService = questionService;
  }

  @Override
  public Flowable<List<Question>> loadQuestions(boolean forceRemote) {
    return questionService.loadQuestionsByTag("android").map(QuestionResponse::getQuestions);
  }

  @Override
  public Question addQuestion(Question question) {
    //Currently, we do not need this for remote source.
    throw new UnsupportedOperationException("Unsupported operation");
  }

  @Override
  public void clearData() {
    //Currently, we do not need this for remote source.
    throw new UnsupportedOperationException("Unsupported operation");
  }
}
