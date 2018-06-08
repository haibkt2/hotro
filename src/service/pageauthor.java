package service;

import database.*;
import model.content;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;


public class pageauthor {

    public static ArrayList<content> list = new ArrayList<>();
    public static Set<String> dsAuthor = new TreeSet<>();

    public pageauthor() {
        list.removeAll(list);
    }

    public ArrayList<content> getDanhSach() throws ClassNotFoundException, SQLException {
        Connection conn = Connect.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from content");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idtin = rs.getInt(1);
                int idmenu = rs.getInt(5);
                String Ten = rs.getString(2);
                String Summary = rs.getString(3);
                String Contents = rs.getString(4);
                String Author = rs.getString(6);
                content c = new content();
                c.setIdtin(idtin);
                c.setTen(Ten);
                c.setSummary(Summary);
                c.setNoidung(Contents);
                c.setAuthor(Author);
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public Set<String> getDanhSachTheoAuthor() throws ClassNotFoundException, SQLException {
        Connection conn = Connect.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from content");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                dsAuthor.add(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return dsAuthor;
    }

    public ArrayList<content> locDanhSach(String Author) throws ClassNotFoundException, SQLException {
        Connection conn = Connect.getConnection();
        ArrayList<content> ds = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from content where author='" + Author + "'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idtin = rs.getInt(1);
                int idmenu = rs.getInt(5);
                String Ten = rs.getString(2);
                String Summary = rs.getString(3);
                String Contents = rs.getString(4);
                String Author1 = rs.getString(6);
                content c = new content();
                c.setIdtin(idtin);
                c.setTen(Ten);
                c.setSummary(Summary);
                c.setNoidung(Contents);
                c.setAuthor(Author1);
                ds.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return ds;
    }
}
