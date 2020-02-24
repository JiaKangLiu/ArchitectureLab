package cn.edu.ncu.architecture.lab.service;

import cn.edu.ncu.architecture.lab.model.*;

import java.util.List;

public interface LabService {

    /*************联系我们接口*************/
    boolean addContact(Contact contact);
    boolean deleteContact(Integer id);
    boolean updateContact(Contact contact);
    Contact getContact(Integer id);

    /************学术交流接口**********/
    boolean addAcademic(CooperationAcademic cooperationAcademic);
    boolean deleteAcademic(Integer id);
    boolean updateAcademic(CooperationAcademic cooperationAcademic);
    CooperationAcademic getAcademic(Integer id);
    List<CooperationAcademic> getAllCooperationAcademic();

    /************国际交流接口**********/
    boolean addInternational(CooperationInternational cooperationInternational);
    boolean deleteInternational(Integer id);
    boolean updateInternational(CooperationInternational cooperationInternational);
    CooperationInternational getInternational(Integer id);
    List<CooperationInternational> getAllInternationals();

    /************校企合作接口**********/
    boolean addSchool(CooperationSchool cooperationSchool);
    boolean deleteSchool(Integer id);
    boolean updateSchool(CooperationSchool cooperationSchool);
    CooperationSchool getSchool(Integer id);
    List<CooperationSchool> getAllSchools();

    /************科技动态接口**********/
    boolean addDynamic(Dynamic dynamic);
    boolean deleteDynamic(Integer id);
    boolean updateDynamic(Dynamic dynamic);
    Dynamic getDynamic(Integer id);
    List<Dynamic> getAllDynamic();

    /************组织机构接口**********/
    boolean addOrganization(Organization organization);
    boolean deleteOrganization(Integer id);
    boolean updateOrganization(Organization organization);
    Organization getOrganization(Integer id);

    /************人才培养接口**********/
    boolean addPersonnel(PersonnelTraining personnelTraining);
    boolean deletePersonnel(Integer id);
    boolean updatePersonnel(PersonnelTraining personnelTraining);
    PersonnelTraining getPersonnel(Integer id);

    /************英才招聘接口**********/
    boolean addRecruit(Recruit recruit);
    boolean deleteRecruit(Integer id);
    boolean updateRecruit(Recruit recruit);
    Recruit getRecruit(Integer id);

    /************研究领域接口**********/
    boolean addResearchAreas(ResearchAreas researchAreas);
    boolean deleteResearchAreas(Integer id);
    boolean updateResearchAreas(ResearchAreas researchAreas);
    ResearchAreas getResearchAreas(Integer id);

    /************研究成果接口**********/
    boolean addResearchResults(ResearchResults researchResults);
    boolean deleteResearchResults(Integer id);
    boolean updateResearchResults(ResearchResults researchResults);
    ResearchResults getResearchResults(Integer id);

    /************研究队伍接口**********/
    boolean addResearchTeam(ResearchTeam researchTeam);
    boolean deleteResearchTeam(Integer id);
    boolean updateResearchTeam(ResearchTeam researchTeam);
    ResearchTeam getResearchTeam(Integer id);

    /************仪器平台接口**********/
    boolean addInstrument(Instrument instrument);
    boolean deleteInstrument(Integer id);
    boolean updateInstrument(Instrument instrument);
    List<Instrument> getAllInstrument();
    Instrument getInstrumentById(Integer id);

    /***********实验室简介*************/
    boolean addIntroduction(Introduction introduction);
    boolean deleteIntroduction(Integer id);
    boolean updateIntroduction(Introduction introduction);
    Introduction getIntroductionById(Integer id);

    /***********工作条例*************/
    boolean addWork(Work work);
    boolean deleteWork(Integer id);
    boolean updateWork(Work work);
    Work getWorkById(Integer id);
    List<Work> getAllWorks();

}
