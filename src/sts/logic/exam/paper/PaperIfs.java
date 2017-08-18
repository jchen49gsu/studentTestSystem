package sts.logic.exam.paper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import sts.vo.ExamVO;



public interface PaperIfs {
   public List<ExamVO> getExamList() throws ClassNotFoundException, SQLException, IOException;
}