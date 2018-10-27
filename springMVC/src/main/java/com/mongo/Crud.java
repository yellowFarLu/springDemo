package com.mongo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class Crud {

    static DB mongoConn = null;

    public static void Connect(DBConnection dbCon) {
        if (dbCon.getDriverName() == DBConnection.DriverName.mongodb) {
            ServerAddress serverAddress = new ServerAddress(dbCon.getServerHost(), Integer.valueOf(dbCon.getServerPort()));
            List<ServerAddress> addrs = new ArrayList<>();
            addrs.add(serverAddress);
            MongoCredential credential = MongoCredential.createScramSha1Credential(dbCon.getUserName(), dbCon.getSource(), dbCon.getPassword().toCharArray());
            List<MongoCredential> credentials = new ArrayList<>();
            credentials.add(credential);

            // 通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(addrs, credentials);

            @SuppressWarnings("deprecation")
            DB con = mongoClient.getDB(dbCon.getDbName());

            mongoConn = con;
        }
    }

    public static String OperateDB(String sql, Boolean hasColumnName) {
        String result = "";
        if (sql.toUpperCase().contains(").FIND(")) {
            result = Query(sql, hasColumnName);

        }
        else if(sql.toUpperCase().contains(").REMOVE("))
        {
            result=String.valueOf(Delete(sql));
        }
        else if(sql.toUpperCase().contains(").UPDATE("))
        {
            result=String.valueOf(Update(sql));
        }
        else {
            result= String.valueOf(Create(sql));
        }
        return result;
    }


    private static String Query(String sql, Boolean hasColumnName) {
        String tableName = RegExpUtil.getTableName(sql);
        String query = RegExpUtil.getQuery(sql);
        List<String> columnNames = getColumnNames(query);

        BasicDBObject queryObject = (BasicDBObject) JSON.parse(query);
        DBCursor cursor = mongoConn.getCollection(tableName).find(queryObject);
        JSONArray lists = new JSONArray();

        while (cursor.hasNext()) {
            JSONObject jsonObj = new JSONObject();
            JSONArray subLists = new JSONArray();
            DBObject o = cursor.next();
            if (!columnNames.isEmpty()) {
                if(!hasColumnName)
                {
                    for (String columnName : columnNames)
                        subLists.add(o.get(columnName));
                    lists.add(subLists);
                }
                else {
                    for (String columnName : columnNames)
                        jsonObj.put(columnName, o.get(columnName));
                    lists.add(jsonObj);
                }
            } else {
                if(!hasColumnName)
                {
                    Iterator<String> it = o.keySet().iterator();
                    while(it.hasNext())
                        subLists.add(o.get(it.next()));
                    lists.add(subLists);
                }
                else {
                    lists.add(o);
                }
            }

        }
        return FastJsonUtil.ObjectToString(lists);
    }

    private static int Create(String sql)
    {
        String tableName = RegExpUtil.getTableName(sql);
        String create = RegExpUtil.getCreate(sql);
        BasicDBObject createObject = (BasicDBObject) JSON.parse(create);
        WriteResult writeResult = mongoConn.getCollection(tableName).save(createObject);
        return writeResult.getN();
    }

    private static int Update(String sql)
    {
        String tableName = RegExpUtil.getTableName(sql);

        String update = RegExpUtil.getUpdate(sql);
        BasicDBObject updateQueryObject = (BasicDBObject) JSON.parse(update);

        String upset = getUpset(update);
        BasicDBObject upsetObject = (BasicDBObject) JSON.parse(upset);
        WriteResult updateResult = mongoConn.getCollection(tableName).update(updateQueryObject, upsetObject);
        return updateResult.getN();
    }

    private static int Delete(String sql)
    {
        String tableName = RegExpUtil.getTableName(sql);
        String delete = RegExpUtil.getRemove(sql);
        BasicDBObject deleteObject = (BasicDBObject) JSON.parse(delete);
        WriteResult writeResult = mongoConn.getCollection(tableName).remove(deleteObject);
        return writeResult.getN();
    }

    private static List<String> getColumnNames(String query) {
        String tmp = RegExpUtil.getObject(query,1);
        return RegExpUtil.getColumnNames(tmp);
    }

    private static String getUpset(String query) {
        String tmp  = RegExpUtil.getObject(query, 1);
        return tmp;
    }
}
