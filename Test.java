import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test_Insert {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1、通过反射技术加载数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //tips: 按住alt和?
        //2、获取Connection连接对象 此处最后一个参数为自己设置的密码
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oadb?serverTimezone=UTC", "root", "password");

        //3、编写Sql语句（意思就是：把sql语句当做一串字符再发送到 mysql 中进行执行）
        String sql = "insert into department values(2, '信息学院', '掌握信息技术');";

        //4、获取preparedStatement对象
        PreparedStatement ps = conn.prepareStatement(sql);

        //5、执行Sql语句
        //executeUpdate() : 执行sql语句
        //语句执行后会产生一个int类型的返回值，修改值表示语句执行后受影响的行数
        int i = ps.executeUpdate();

        //输出执行结果
        if(i > 0) {
            System.out.println("数据添加成功");
        }
        else {
            System.out.println("数据添加失败");
        }

    }

}

