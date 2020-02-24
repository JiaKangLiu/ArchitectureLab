package cn.edu.ncu.architecture.lab.test;

import cn.edu.ncu.architecture.lab.model.Contact;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDao {
    public static void main(String args[]) throws ParseException {
        //日期格式转换
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time=new Long(445555555);
        String d = format.format(time);
        Date date=format.parse(d);
        System.out.println("Format To String(Date):"+d);
        System.out.println("Format To Date:"+date);
        //获取当前系统时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("当前系统时间："+df.format(new Date()));// new Date()为获取当前系统时间
        //当前时间毫秒数
        System.out.println(new Date().getTime());
        Contact contact = new Contact();
//        LocalDateTime localDateTime = LocalDateTime.now();
//        contact.setTime(new Date());
        System.out.println("====contact.getTime():"+contact.getTime());
        Time time1 = new Time(1511111111);
        System.out.println(time1.toString());
        System.out.println("--------------------------------------------");
        String date1 = df.format(new Date());
        System.out.println(date1);
    }
}
