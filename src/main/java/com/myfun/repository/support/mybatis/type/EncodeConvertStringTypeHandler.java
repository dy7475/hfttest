package com.myfun.repository.support.mybatis.type;

import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.StringTypeHandler;

/**
 * mysql数据库为拉丁字符 读取和写入数据库时 装对字符进行转换
 * 
 * @author jiangsonggui
 *
 */
public class EncodeConvertStringTypeHandler extends StringTypeHandler {

	@Override
	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String result = super.getResult(cs, columnIndex);
		try {
			if (result != null) {
				result = new String(result.getBytes("ISO-8859-1"), "GBK");
			}
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}

	@Override
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		String result = super.getResult(rs, columnIndex);
		try {
			if (result != null) {
				result = new String(result.getBytes("ISO-8859-1"), "GBK");
			}
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}

	@Override
	public String getResult(ResultSet rs, String columnName) throws SQLException {
		String result = super.getResult(rs, columnName);
		try {
			if (result != null) {
				result = new String(result.getBytes("ISO-8859-1"), "GBK");
			}
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}

	@Override
	public void setConfiguration(Configuration c) {
		super.setConfiguration(c);
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, String param, JdbcType arg3) throws SQLException {
		try {
			if (param != null) {
				param = new String(param.getBytes("GBK"), "ISO-8859-1");
			}
		} catch (UnsupportedEncodingException e) {
		}
		super.setParameter(arg0, arg1, param, arg3);
	}

}
