package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.db.DBConnect;
import vn.edu.hcmuaf.fit.db.JDBIConnector;
import vn.edu.hcmuaf.fit.model.Account;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static UserService instance;


    private UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    public User checkLogin(String email, String password) {
        List<User> users = JDBIConnector.get().withHandle(h ->
                h.createQuery("SELECT taikhoan.ID, taikhoan.email, taikhoan.PASS, taikhoan.tentk, taikhoan.ROLE FROM taikhoan WHERE email = ?")
                        .bind(0, email)
                        .mapToBean(User.class)
                        .stream()
                        .collect(Collectors.toList())
        );
        if (users.size() != 1) return null;
        User user = users.get(0);
        if (!user.getPass().equals(hashPassword(password))
                ||!user.getEmail().equals(email)) return null;
        return user;
    }
    public static String hashPassword(String password) {
        try {
            MessageDigest sha256 = null;
            sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hash = sha256.digest(password.getBytes());
            BigInteger number = new BigInteger(1, hash);
            return number.toString(16);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    public static User findById(String Id){
        List<User> list = getListAcc();
        for (User u: list) {
            if(Id.equals(u.getId())){
                return u;
            }

        }
        return null;
    }

    public static List<User> getListAcc(){
        List<User> list = new ArrayList<User>();
        Statement statement = DBConnect.getInstall().get();
        if(statement !=null){
            try{
                ResultSet rsAcc = statement.executeQuery("select ID, EMAIL, PASS, TENTK, ROLE from taikhoan;");
                while(rsAcc.next()){
                    list.add(new User(rsAcc.getString(1), rsAcc.getString(2), rsAcc.getString(3), rsAcc.getString(4), rsAcc.getInt(5)));
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Không có tai khoan");
        }
        return list;

    }
    public static boolean checkEmail(String email){
        List<User> list = getListAcc();
        List<String> listEmail = new ArrayList<String>();
        for(User a : list){
            listEmail.add(a.getEmail());
        }
        if (!listEmail.contains(email)) {
            return true;
        }
        return false;
    }
    public static void register(User acc){
        Statement stm = DBConnect.getInstall().get();
        List<User> list = getListAcc();
        String ID = "AD" + (list.size() + 1);
        acc.setId(ID);
        if(stm!= null) {
            try {
                    String sql = "insert into taikhoan values ('" + ID + "', '" + acc.getEmail() + "', '" + hashPassword(acc.getPass())  + "', '" + acc.getTentk() + "'," + acc.getRole()+");";
                    stm.executeUpdate(sql);
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
//        UserService userService = new UserService();
//       System.out.println(userService.checkLogin("thanhthuy@gmail.com", "123").toString());
//       System.out.println(userService.hashPassword("123"));
//       System.out.println(userService.hashPassword("456"));
//       System.out.println(userService.hashPassword("789"));
//       System.out.println(userService.hashPassword("nhom27"));
//        UserService.register(new Account("Thanh@gmail.com","12","Thanh"));

        System.out.println(UserService.checkEmail("thanh@gmail.com"));

    }
}
