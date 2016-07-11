package customTools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import model.Student;



public class Dataget {
	
	
	public static List<Student> Student (){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select b from Student b";
        
        List<Student> posts = null;
        try{
            TypedQuery<Student> query = em.createQuery(qString,Student.class);
            posts = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return posts;
    }
	
    public static long getgradeid (String gradeid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Long> gradeids=new ArrayList<Long>();
        String qString = "select b.gradeid from Student b";
        long longgradeid=0;
        try{
            Query query = em.createQuery(qString,Student.class);           
            gradeids=query.getResultList();
            
            for(long a: gradeids)
            {
            	if(Long.toString(a).equals(gradeid))
            	{
            		longgradeid=a;
            	}
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return longgradeid;    
    }
    
    
    public static Student studentofstudentid (long gradeid){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select b from Student b where b.gradeid = :gradeid";
        
        Student stu = null;
        try{
            TypedQuery<Student> query = em.createQuery(qString,Student.class);
            query.setParameter("gradeid", gradeid);
            stu = query.getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return stu;
    }
    public static void delete(Student stu) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(stu));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static Date todate(String date)
    {
    	DateFormat df = new SimpleDateFormat("yy-MMM-dd"); 
        Date startDate=null;
        try {
            startDate = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startDate;
    }
    
    public static void update(Student stu) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(stu);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
	public static void insert(Student stu) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(stu);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	
	public static List<Student> searchbystudent (String search)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Student> searchstudents = null;
        String qString = "select b from Student b "
                + "where b.studentid like :search";
        
        try{
            TypedQuery<Student> query = em.createQuery(qString,Student.class);
            query.setParameter("search", "%" + search + "%");
            searchstudents = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchstudents;
    }
	public static List<Student> searchbyhomework ()
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Student> searchstudents = null;
        String qString = "select b from Student b "
                + "where b.type =:type";
        
        try{
            TypedQuery<Student> query = em.createQuery(qString,Student.class);
            query.setParameter("type", "homework");
            searchstudents = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchstudents;
    }
	public static List<Student> searchbyhomework (String studentid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Student> searchstudents = null;
        String qString = "select b from Student b "
                + "where b.studentid=:studentid and b.type =:type";
        
        try{
            TypedQuery<Student> query = em.createQuery(qString,Student.class);
            query.setParameter("type", "homework");
            query.setParameter("studentid", studentid);
            searchstudents = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchstudents;
    }
	public static List<Student> searchbyquiz ()
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Student> searchstudents = null;
        String qString = "select b from Student b "
                + "where b.type =:type";
        
        try{
            TypedQuery<Student> query = em.createQuery(qString,Student.class);
            query.setParameter("type", "quiz");
            searchstudents = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchstudents;
    }
	public static List<Student> searchbyquiz (String studentid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Student> searchstudents = null;
        String qString = "select b from Student b "
                + "where b.studentid=:studentid and b.type =:type";
        
        try{
            TypedQuery<Student> query = em.createQuery(qString,Student.class);
            query.setParameter("type", "quiz");
            query.setParameter("studentid", studentid);
            searchstudents = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchstudents;
    }
	public static List<Student> searchbytest ()
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Student> searchstudents = null;
        String qString = "select b from Student b "
                + "where b.type =:type";
        
        try{
            TypedQuery<Student> query = em.createQuery(qString,Student.class);
            query.setParameter("type", "test");
            searchstudents = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchstudents;
    }
	
	public static List<Student> searchbytest (String studentid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Student> searchstudents = null;
        String qString = "select b from Student b "
                + "where b.studentid =:studentid and b.type =:type";
        
        try{
            TypedQuery<Student> query = em.createQuery(qString,Student.class);
            query.setParameter("type", "test");
            query.setParameter("studentid", studentid);
            searchstudents = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchstudents;
    }
	public static List<Student> searchbyproject ()
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Student> searchstudents = null;
        String qString = "select b from Student b "
                + "where b.type =:type";
        
        try{
            TypedQuery<Student> query = em.createQuery(qString,Student.class);
            query.setParameter("type", "project");
            searchstudents = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchstudents;
    }
	public static List<Student> searchbyproject (String studentid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Student> searchstudents = null;
        String qString = "select b from Student b "
                + "where b.studentid=:studentid and b.type =:type";
        
        try{
            TypedQuery<Student> query = em.createQuery(qString,Student.class);
            query.setParameter("type", "project");
            query.setParameter("studentid", studentid);
            searchstudents = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchstudents;
    }
	
	public static HashMap<String, String> averagebystudent ()
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        HashMap<String, String> averagebystudent=new HashMap<String,String>();
        String qString = "select b.studentid,avg(b.grade) from Student b group by b.studentid";
        try{
            Query query = em.createQuery(qString);
            List<Object[]> resultList = query.getResultList();
            for(Object[] result: resultList)
            {
            	
            	averagebystudent.put(result[0].toString(),result[1].toString());
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
            
        }
        System.out.println(averagebystudent.keySet());
        return averagebystudent;
    }
	
	public static HashMap<String, String> averagebystudenttype (String studentid)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        HashMap<String, String> averagebystudent=new HashMap<String,String>();
        String qString = "select b.type, avg(b.grade) from Student b where b.studentid=:studentid group by b.type";
        try{
            Query query = em.createQuery(qString);
            query.setParameter("studentid", studentid);
            List<Object[]> resultList = query.getResultList();
            for(Object[] result: resultList)
            {
            	averagebystudent.put(result[0].toString(),result[1].toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return averagebystudent;
    }
	
	public static HashMap<String, HashMap<String,String>> highlowbytype ()
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();   
        HashMap<String, HashMap<String,String>> averagebystudent=new HashMap<String,HashMap<String,String>>();
        HashMap<String, String> smallmap=new HashMap<String,String>();
        String qString = "select b.type,max(b.grade) ,min(b.grade)  from Student b group by b.type";
        try{
            Query query = em.createQuery(qString);
            List<Object[]> resultList = query.getResultList();
            for(Object[] result: resultList)
            {
            	smallmap.put(result[1].toString(),result[2].toString());
            	averagebystudent.put(result[0].toString(), smallmap);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return averagebystudent;
    }
	
	

}
