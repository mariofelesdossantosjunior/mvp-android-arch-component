package com.quangnguyen.stackoverflowclient.data.repository.local;

import com.quangnguyen.stackoverflowclient.data.database.QuestionDao;
import com.quangnguyen.stackoverflowclient.data.model.Question;
import com.quangnguyen.stackoverflowclient.data.repository.QuestionDataSource;
import io.reactivex.Flowable;
import java.util.List;
import javax.inject.Inject;

/**
 * @author QuangNguyen (quangctkm9207).
 */
public class QuestionLocalDataSource implements QuestionDataSource {

  private QuestionDao questionDao;

  @Inject
  public QuestionLocalDataSource(QuestionDao questionDao) {
    this.questionDao = questionDao;
  }

  @Override
  public Flowable<List<Question>> loadQuestions(boolean forceRemote) {
    return questionDao.getAllQuestions();
  }

  @Override
  public Question addQuestion(Question question) {
    // Insert new one
    questionDao.insert(question);
    return question;
  }

  @Override
  public void clearData() {
    // Clear old data
    questionDao.deleteAll();
  }
}
