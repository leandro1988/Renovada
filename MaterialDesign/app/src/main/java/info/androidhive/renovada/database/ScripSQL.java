package info.androidhive.renovada.database;

/**
 * Created by leandro on 29/12/16.
 */

public class ScripSQL  {

    public static String getCreateContato() {


        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE IF NOT EXISTS MEMBROS ( ");
        sqlBuilder.append("id               INTEGER      NOT NULL ");
        sqlBuilder.append("PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("NOME              TEXT, ");
        sqlBuilder.append("CELULAR           TEXT, ");
        sqlBuilder.append("TELEFONE          TEXT, ");
        sqlBuilder.append("ENDERECO          TEXT, ");
        sqlBuilder.append("BAIRRO            TEXT, ");
        sqlBuilder.append("DATANASC          TEXT, ");
        sqlBuilder.append("CAMPO             TEXT, ");
        sqlBuilder.append("IGREJA            TEXT, ");
        sqlBuilder.append("DATA              TEXT ");
        sqlBuilder.append("); ");

     return sqlBuilder.toString();
    }
}
