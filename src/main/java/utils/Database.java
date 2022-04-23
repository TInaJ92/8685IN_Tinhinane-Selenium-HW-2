package utils;

import config.Config;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Database {

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    public Database() {
        Map<Object, String> dbConfig = Config.databaseConfig();

        try {
            Class.forName((dbConfig.get(Config.DBProperties.DRIVER_CLASS)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connect = DriverManager.getConnection(dbConfig.get(Config.DBProperties.HOST),
                    dbConfig.get(Config.DBProperties.USER), dbConfig.get(Config.DBProperties.PASSWORD));
            System.out.println("CONNECTED TO DATABASE!");
        } catch (SQLException sql) {
            System.out.println("\nUNABLE TO ESTABLISH CONNECTION TO DATABASE:\n" + sql.getMessage() + "\n");
        }
    }

    /**
     * Submits and executes a database query and returns the resultSet
     * @param query The SQL query to be executed
     * @return The resultSet
     */
    public ResultSet executeQuery(String query) {
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException sql) {
            System.out.println("UNABLE TO RETRIEVE RESULTS FROM QUERY: " + query);
            System.out.println(sql.getMessage());
        }

        return resultSet;
    }

    /**
     * @throws SQLException
     *
     * Executes a query, reads & parses the entire resultSet and returns a List containing each row of data as a list.
     * (The inner lists represent each row of data)
     *
     * @return Entire result set as a List<List<String>>
     */
    public List<List<String>> executeQueryReadAll(String query) throws SQLException {
        resultSet = executeQuery(query);
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        List<List<String>> data = new ArrayList<>();
        while (resultSet.next()) {
            List<String> row = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(resultSet.getString(i));
            }
            data.add(row);
        }
        return data;
    }

    /**
     * @throws SQLException
     *
     * Executes a query, reads & parses the resultSet specified by column name and returns a List containing each cell
     * value in that column
     *
     * @param query The query to be executed
     * @param columnName Identifies the column to read data_structures.data from
     * @return All cell values within the specified column, resulting from the query's execution
     */
    public List<String> executeQueryReadAllSingleColumn(String query, String columnName) throws SQLException {
        resultSet = executeQuery(query);
        List<String> dataList = new ArrayList<>();
        String item;

        while (resultSet.next()) {
            item = resultSet.getString(columnName);
            dataList.add(item);
        }
        return dataList;
    }

    /**
     * @throws SQLException
     *
     * Executes a query, reads & parses the resultSet specified by column number and returns a List containing each cell
     * value in that column.
     *
     * Database columns start at 1
     *
     * @param query The query to be executed
     * @param columnNumber Identifies the column to read data_structures.data from (e.g. - 1 = 1st column, 2 = 2nd column...)
     * @return All cell values within the specified column, resulting from the query's execution
     */
    public List<String> executeQueryReadAllSingleColumn(String query, int columnNumber) throws Exception {
        resultSet = executeQuery(query);
        List<String> dataList = new ArrayList<>();
        String item;

        while (resultSet.next()) {
            item = resultSet.getString(columnNumber);
            dataList.add(item);
        }
        return dataList;
    }

    /**
     * @throws SQLException
     *
     * Executes a query, reads & returns the first cell in the first row in the first column
     *
     * @param query The query to be executed
     * @return Single cell value resulting from the query's execution
     */
    public Object executeQueryReadOne(String query) throws SQLException {
        Object result = null;
        resultSet = executeQuery(query);

        if (resultSet.next()) {
            result = resultSet.getString(1);
        }

        return result;
    }

}
