package jdbc.dao;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class HeroDaoImpl implements HeroDao {
    private final DataSource dataSource;

    @Override
    public List<Hero> findAll() {
        var sql = "SELECT * FROM heroes";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Hero> mapHeroes(ResultSet result) throws SQLException {
        var heroes = new ArrayList<Hero>();
        while (result.next()) {
            heroes.add(Hero.builder()
                    .name(result.getString("name"))
                    .gender(result.getString("gender"))
                    .eye_color(result.getString("eye_color"))
                    .race(result.getString("race"))
                    .hair_color(result.getString("hair_color"))
                    .height(result.getDouble("height"))
                    .publisher(result.getString("publisher"))
                    .skin_color(result.getString("skin_color"))
                    .alignment(result.getString("alignment"))
                    .weight(result.getInt("weight"))
                    .build());
        }
        return heroes;
    }

    @Override
    public List<Hero> findByName(String name) {
        var sql = "SELECT * FROM heroes WHERE name = '" + name + "'";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Hero hero) {
        var sql = """
                "INSERT INTO heroes (name, gender, eyeColor, race, hairColor, height, publisher" +
                ", skinColor, alignment, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
                """;
        statementConnection(hero, sql);
    }

    @Override
    public void update(Hero hero) {
        var sql = """
                  UPDATE heroes SET name = ?, gender = ?, eyeColor = ?, race = ?,
                   hairColor = ?, height = ?, publisher = ?, skinColor = ?,
                   alignment = ?, weight = ? WHERE id = ?
                """;
        statementConnection(hero, sql);
    }

    private void statementConnection(Hero hero, String sql) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setString(1, hero.getName());
            statement.setString(2, hero.getGender());
            statement.setString(3, hero.getEye_color());
            statement.setString(4, hero.getRace());
            statement.setString(5, hero.getHair_color());
            statement.setDouble(6, hero.getHeight());
            statement.setString(7, hero.getPublisher());
            statement.setString(8, hero.getSkin_color());
            statement.setString(9, hero.getAlignment());
            statement.setInt(10, hero.getWeight());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        var sql = "DELETE FROM heroes WHERE id = ?";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
