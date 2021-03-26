package hu.nive.ujratervezes.zarovizsga.housecup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCup {

    private final DataSource dataSource;

    public HouseCup(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int getPointsOfHouse(String house) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select sum(points_earned) as points from house_points where house_name = ?")) {
            ps.setString(1, house);
            return selectPointsOfHouseByPS(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
    }

    private int selectPointsOfHouseByPS(PreparedStatement ps) {
        int result = 0;
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                result = rs.getInt("points");
            }
            return result;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query!", se);
        }
    }
}
