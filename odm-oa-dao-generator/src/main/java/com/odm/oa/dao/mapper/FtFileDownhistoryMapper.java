package com.odm.oa.dao.mapper;

import com.odm.oa.dao.pojo.FtFileDownhistory;
import java.util.List;

public interface FtFileDownhistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FT_File_Downhistory
     *
     * @mbggenerated Sat Jul 14 20:25:19 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FT_File_Downhistory
     *
     * @mbggenerated Sat Jul 14 20:25:19 CST 2018
     */
    int insert(FtFileDownhistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FT_File_Downhistory
     *
     * @mbggenerated Sat Jul 14 20:25:19 CST 2018
     */
    FtFileDownhistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FT_File_Downhistory
     *
     * @mbggenerated Sat Jul 14 20:25:19 CST 2018
     */
    List<FtFileDownhistory> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FT_File_Downhistory
     *
     * @mbggenerated Sat Jul 14 20:25:19 CST 2018
     */
    int updateByPrimaryKey(FtFileDownhistory record);
}