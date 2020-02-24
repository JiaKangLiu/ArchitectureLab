package cn.edu.ncu.architecture.lab.service.serviceImpl;

import cn.edu.ncu.architecture.lab.dao.*;
import cn.edu.ncu.architecture.lab.model.*;
import cn.edu.ncu.architecture.lab.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("LabService")
public class LabServiceImpl implements LabService {
    /**
     * 自动注入dao对象
     */

    @Autowired
    ContactDao contactDao;

    @Autowired
    CooperationAcademicDao cooperationAcademicDao;

    @Autowired
    CooperationInternationalDao cooperationInternationalDao;

    @Autowired
    CooperationSchoolDao cooperationSchoolDao;

    @Autowired
    DynamicDao dynamicDao;

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    PersonnelDao personnelDao;

    @Autowired
    RecruitDao recruitDao;

    @Autowired
    ResearchAreasDao researchAreasDao;

    @Autowired
    ResearchResultsDao researchResultsDao;

    @Autowired
    ResearchTeamDao researchTeamDao;

    @Autowired
    InstrumentDao instrumentDao;

    @Autowired
    IntroductionDao introductionDao;

    @Autowired
    WorkDao workDao;

    /********************联系我们接口实现********************/
    @Override
    public boolean addContact(Contact contact) {
        return contactDao.insertContact(contact);
    }

    @Override
    public boolean deleteContact(Integer id) {
        return contactDao.deleteContact(id);
    }

    @Override
    public boolean updateContact(Contact contact) {
        return contactDao.updateContact(contact);
    }

    @Override
    public Contact getContact(Integer id) {
        return contactDao.findContactById(id);
    }

    /*******************学术交流接口实现**********************/
    @Override
    public boolean addAcademic(CooperationAcademic cooperationAcademic) {
        return cooperationAcademicDao.insertAcademic(cooperationAcademic);
    }

    @Override
    public boolean deleteAcademic(Integer id) {
        return cooperationAcademicDao.deleteAcademic(id);
    }

    @Override
    public boolean updateAcademic(CooperationAcademic cooperationAcademic) {
        return cooperationAcademicDao.updateAcademic(cooperationAcademic);
    }

    @Override
    public CooperationAcademic getAcademic(Integer id) {
        return cooperationAcademicDao.findAcademicById(id);
    }

    @Override
    public List<CooperationAcademic> getAllCooperationAcademic(){
        return cooperationAcademicDao.findAllCooperationAcademic();
    }

    /*******************国际交流接口实现**********************/
    @Override
    public boolean addInternational(CooperationInternational cooperationInternational) {
        return cooperationInternationalDao.insertInternational(cooperationInternational);
    }

    @Override
    public boolean deleteInternational(Integer id) {
        return cooperationInternationalDao.deleteInternational(id);
    }

    @Override
    public boolean updateInternational(CooperationInternational cooperationInternational) {
        return cooperationInternationalDao.updateInternational(cooperationInternational);
    }

    @Override
    public CooperationInternational getInternational(Integer id) {
        return cooperationInternationalDao.findInternationalById(id);
    }

    @Override
    public List<CooperationInternational> getAllInternationals(){
        return cooperationInternationalDao.findAllInternationals();
    }

    /*******************校企合作接口实现**********************/
    @Override
    public boolean addSchool(CooperationSchool cooperationSchool) {
        return cooperationSchoolDao.insertSchool(cooperationSchool);
    }

    @Override
    public boolean deleteSchool(Integer id) {
        return cooperationSchoolDao.deleteSchool(id);
    }

    @Override
    public boolean updateSchool(CooperationSchool cooperationSchool) {
        return cooperationSchoolDao.updateSchool(cooperationSchool);
    }

    @Override
    public CooperationSchool getSchool(Integer id) {
        return cooperationSchoolDao.findSchoolById(id);
    }

    @Override
    public List<CooperationSchool> getAllSchools(){
        return cooperationSchoolDao.findAllSchools();
    }

    /*******************科技动态接口实现**********************/
    @Override
    public boolean addDynamic(Dynamic dynamic) {
        return dynamicDao.insertDynamic(dynamic);
    }

    @Override
    public boolean deleteDynamic(Integer id) {
        return dynamicDao.deleteDynamic(id);
    }

    @Override
    public boolean updateDynamic(Dynamic dynamic) {
        return dynamicDao.updateDynamic(dynamic);
    }

    @Override
    public Dynamic getDynamic(Integer id) {
        return dynamicDao.findDynamicById(id);
    }

    @Override
    public List<Dynamic> getAllDynamic(){
        return dynamicDao.findAllDynamic();
    }

    /*******************组织机构接口实现**********************/
    @Override
    public boolean addOrganization(Organization organization) {
        return organizationDao.insertOrganization(organization);
    }

    @Override
    public boolean deleteOrganization(Integer id) {
        return organizationDao.deleteOrganization(id);
    }

    @Override
    public boolean updateOrganization(Organization organization) {
        return organizationDao.updateOrganization(organization);
    }

    @Override
    public Organization getOrganization(Integer id) {
        return organizationDao.findOrganizationById(id);
    }

    /*******************人才培养接口实现**********************/
    @Override
    public boolean addPersonnel(PersonnelTraining personnelTraining) {
        return personnelDao.insertPersonnel(personnelTraining);
    }

    @Override
    public boolean deletePersonnel(Integer id) {
        return personnelDao.deletePersonnel(id);
    }

    @Override
    public boolean updatePersonnel(PersonnelTraining personnelTraining) {
        return personnelDao.updatePersonnel(personnelTraining);
    }

    @Override
    public PersonnelTraining getPersonnel(Integer id) {
        return personnelDao.findPersonnelById(id);
    }

    /*******************英才招聘接口实现**********************/
    @Override
    public boolean addRecruit(Recruit recruit) {
        return recruitDao.insertRecruit(recruit);
    }

    @Override
    public boolean deleteRecruit(Integer id) {
        return recruitDao.deleteRecruit(id);
    }

    @Override
    public boolean updateRecruit(Recruit recruit) {
        return recruitDao.updateRecruit(recruit);
    }

    @Override
    public Recruit getRecruit(Integer id) {
        return recruitDao.findRecruitById(id);
    }

    /*******************研究领域接口实现**********************/
    @Override
    public boolean addResearchAreas(ResearchAreas researchAreas) {
        return researchAreasDao.insertResearchAreas(researchAreas);
    }

    @Override
    public boolean deleteResearchAreas(Integer id) {
        return researchAreasDao.deleteResearchAreas(id);
    }

    @Override
    public boolean updateResearchAreas(ResearchAreas researchAreas) {
        return researchAreasDao.updateResearchAreas(researchAreas);
    }

    @Override
    public ResearchAreas getResearchAreas(Integer id) {
        return researchAreasDao.findResearchAreasById(id);
    }

    /*******************研究成果接口实现**********************/
    @Override
    public boolean addResearchResults(ResearchResults researchResults) {
        return researchResultsDao.insertResearchResults(researchResults);
    }

    @Override
    public boolean deleteResearchResults(Integer id) {
        return researchResultsDao.deleteResearchResults(id);
    }

    @Override
    public boolean updateResearchResults(ResearchResults researchResults) {
        return researchResultsDao.updateResearchResults(researchResults);
    }

    @Override
    public ResearchResults getResearchResults(Integer id) {
        return researchResultsDao.findResearchResultsById(id);
    }

    /*******************研究队伍接口实现**********************/
    @Override
    public boolean addResearchTeam(ResearchTeam researchTeam) {
        return researchTeamDao.insertResearchTeam(researchTeam);
    }

    @Override
    public boolean deleteResearchTeam(Integer id) {
        return researchTeamDao.deleteResearchTeam(id);
    }

    @Override
    public boolean updateResearchTeam(ResearchTeam researchTeam) {
        return researchTeamDao.updateResearchTeam(researchTeam);
    }

    @Override
    public ResearchTeam getResearchTeam(Integer id) {
        return researchTeamDao.findResearchTeamById(id);
    }

    /*******************仪器平台接口实现**********************/
    @Override
    public boolean addInstrument(Instrument instrument) {
        return instrumentDao.insertInstrument(instrument);
    }

    @Override
    public boolean deleteInstrument(Integer id) {
        return instrumentDao.deleteInstrument(id);
    }

    @Override
    public boolean updateInstrument(Instrument instrument) {
        return instrumentDao.updateInstrument(instrument);
    }

    @Override
    public List<Instrument> getAllInstrument() {
        return instrumentDao.findAllInstrument();
    }

    @Override
    public Instrument getInstrumentById(Integer id) {
        return instrumentDao.findInstrumentById(id);
    }

    /*******************实验室简介接口实现**********************/

    @Override
    public boolean addIntroduction(Introduction introduction) {
        return introductionDao.insertIntroduction(introduction);
    }

    @Override
    public boolean deleteIntroduction(Integer id) {
        return introductionDao.deleteIntroduction(id);
    }

    @Override
    public boolean updateIntroduction(Introduction introduction) {
        return introductionDao.updateIntroduction(introduction);
    }

    @Override
    public Introduction getIntroductionById(Integer id) {
        return introductionDao.findIntroductionById(id);
    }

    /*******************工作条例接口实现**********************/

    @Override
    public boolean addWork(Work work) {
        return workDao.insertWork(work);
    }

    @Override
    public boolean deleteWork(Integer id) {
        return workDao.deleteWork(id);
    }

    @Override
    public boolean updateWork(Work work) {
        return workDao.updateWork(work);
    }

    @Override
    public Work getWorkById(Integer id) {
        return workDao.findWorkById(id);
    }

    @Override
    public List<Work> getAllWorks() {
        return workDao.findAllWorks();
    }
}
