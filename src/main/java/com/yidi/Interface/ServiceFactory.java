package com.yidi.Interface;

import com.yidi.DapImpl.DBService;

public interface ServiceFactory {
	ParameterService getparameterService();
	AboutParametersDAO getparameterDao(DBService helper);
	DBService getDBhelper();
	AboutQuestionDAO getquestionDao();
	AboutSolutionDAO getsolutionDao();
}
