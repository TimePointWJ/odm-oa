package com.odm.oa.dao.mapper;

import com.odm.oa.dao.pojo.JhAuthRolefun;
import java.util.List;

public interface JhAuthRolefunMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JH_Auth_RoleFun
     *
     * @mbggenerated Sat Jul 14 20:25:19 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JH_Auth_RoleFun
     *
     * @mbggenerated Sat Jul 14 20:25:19 CST 2018
     */
    int insert(JhAuthRolefun record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JH_Auth_RoleFun
     *
     * @mbggenerated Sat Jul 14 20:25:19 CST 2018
     */
    JhAuthRolefun selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JH_Auth_RoleFun
     *
     * @mbggenerated Sat Jul 14 20:25:19 CST 2018
     */
    List<JhAuthRolefun> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table JH_Auth_RoleFun
     *
     * @mbggenerated Sat Jul 14 20:25:19 CST 2018
     */
    int updateByPrimaryKey(JhAuthRolefun record);
}