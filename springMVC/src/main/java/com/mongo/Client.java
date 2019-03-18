package com.mongo;

/**
 * @author huangy on 2018/7/24
 */
public class Client {

    public static void main(String[] args) {
        DBConnection conn = new DBConnection();
        conn.setDbConnectionName("113_toc_log");
        conn.setSource("127.0.0.1");
        conn.setDbName("runoob");
        conn.setDriverName(DBConnection.DriverName.mongodb);
        conn.setServerHost("");
        conn.setServerPort("27017");
        conn.setUserName("pay_toc");
        conn.setPassword("");
        String querySqlWithFields = "db.getCollection('toc_log').find({})";

        Crud.Connect(conn);

        System.out.println(Crud.OperateDB(querySqlWithFields, false));
        System.out.println(Crud.OperateDB(querySqlWithFields, true));
    }
}
