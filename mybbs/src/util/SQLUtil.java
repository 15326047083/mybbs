package util;

/**
 * Sql语句静态类
 * 
 * @author leiyuan
 *
 */
public class SQLUtil {

	public static String newArea = "insert into area values(null,?,?,?)";
	public static String newUser = "insert into user values(null,?,?,?,?,?,?,?,?,?)";
	public static String newDiscuss = "insert into discuss values(null,?,?,?,?,?)";
	public static String newPlate = "insert into plate values(null,?,?,?,?)";
	public static String newPost = "insert into post values(null,?,?,?,?,?,?,?)";
	public static String newReply = "insert into reply values(null,?,?,?,?)";
	public static String updateArea = "update area set name =?,info=?,plateNum=? where id=?";
	public static String updateUser = "update user set name =?,email=?,password=?,sex=?,age=?,birthday=?,plateId=?,time=?,power=? where id=?";
	public static String updatePlate = "update plate set name =?,info=?,areaId=?,postNum=? where id=?";
	public static String updatePost = "update post set userId =?,plateId=?,title=?,info=?,time=?,info=?,flag=?,photonum=? where id=?";
	public static String deleteArea = "delete from area where id=?";
	public static String deleteUser = "delete from user where id=?";
	public static String deleteDiscuss = "delete from discuss where id=?";
	public static String deletePlate = "delete from plate where id=?";
	public static String deletePost = "delete from post where id=?";
	public static String deleteReply = "delete from reply where id=?";
	public static String getByIdFirstSql = "select * from ";
	public static String getByIdSecondSql = " where id=?";
	public static String getListFirstSql = "select * from ";
	public static String getListSecondSql = " limit ?,15";
	public static String firstCountSql = "select count(*) from ";
}
