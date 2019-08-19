package com.ciao.oauth2.resources.constant;

/**
 * @program: ofm1000_datacenter
 * @author: xuechaoke
 * @description:
 * @create: 2019-08-01 17:38
 **/

public class Constant {
    public static final String  USER_LOGIN_INFO_KEY="dataEngine:userInfo";


    public static final String  DEVICEID__SECRET_KEY="deviceId&secretKey";
    public static final Integer  DATA_ENGINE_ROOT_ID=1;

    public static final String  SALT_DEVICEID_KEY="salt&deviceId";


    public static final String  XML_FILE_EXTENSION="xml";


    public static final String  PNG_FILE_EXTENSION="png";
    public static final String  BMP_FILE_EXTENSION="bmp";
    public static final String  JPG_FILE_EXTENSION="jpg";
    public static final String  JAR_FILE_EXTENSION="jar";
    public static final String  XLSX_FILE_EXTENSION="xlsx";
    public static final String  XLS_FILE_EXTENSION="xls";
    public static final String  APK_FILE_EXTENSION="apk";


    public static final String  XLSX_FILE_HEAD_Hex28="504B03040A0000000000874EE2400000000000000000000000000900";



    public static final Long TOKEN_LIVE_TIME =  24 * 60 * 60L;



    /**
     * 成功
     */
   public static final int SUCCESS = 1;
    /**
     * 失败
     */
   public static final int FAIL = 0;
    /**
     * OK
     */
   public static final String OK = "OK";


    /**
     *  升序
     */
   public static final String ASC = "asc";
    /**
     * 降序
     */
   public static final String DESC = "desc";
    /**
     * 删除字段名
     */
   public static final String DEL_FLAG = "del_flag";
    /**
     * 创建时间字段名
     */
   public static final String CREATE_DATE = "create_time";


    /**
     * 当前页码
     */
   public static final String PAGE = "page";
    /**
     * 每页显示记录数
     */
   public static final String LIMIT = "limit";
    /**
     * 排序字段
     */
       public static final String ORDER_FIELD = "orderField";
    /**
     * 排序方式
     */
   public static final String ORDER = "order";
    /**
     * token header
     */
   public static final String TOKEN_HEADER = "token";
}
