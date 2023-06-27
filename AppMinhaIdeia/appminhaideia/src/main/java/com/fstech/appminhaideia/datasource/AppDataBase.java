package com.fstech.appminhaideia.datasource;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.fstech.appminhaideia.api.AppUtil;
import com.fstech.appminhaideia.datamodel.ClienteDataModel;
import com.fstech.appminhaideia.datamodel.ProdutoDataModel;
import com.fstech.appminhaideia.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "AppMinhaIdeia.sqllite";
    public static final int DB_VERSION = 1;
    SQLiteDatabase db;


    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.i(AppUtil.TAG, "AppDataBase: Criando Banco de Dados");

        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(ClienteDataModel.criarTabela());
        db.execSQL(ProdutoDataModel.criarTabela());

        Log.d(AppUtil.TAG, "onCreate Tabela Cliente criada... " + ClienteDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        boolean retorno = false;

        try {
            retorno = db.insert(tabela, null, dados) > 0;
        } catch (Exception e) {

            Log.d(AppUtil.TAG, "insert : " + e.getMessage());

        }
        return retorno;
    }

    public boolean deleteById(String tabela, int id) {
        db = getWritableDatabase();

        boolean retorno = false;

        try {
            retorno = db.delete(tabela, "id = ?", new String[]{String.valueOf(id)}) > 0;
        } catch (Exception e) {

            Log.d(AppUtil.TAG, "delete : " + e.getMessage());

        }
        return false;
    }

    public boolean update(String tabela, ContentValues dados) {
        db = getWritableDatabase();

        boolean retorno = false;

        try {
            retorno = db.update(ClienteDataModel.TABELA, dados,
                    "id=?",
                    new String[]{String.valueOf(dados.get("id"))}) > 0;
        } catch (Exception e) {

            Log.d(AppUtil.TAG, "update : " + e.getMessage());

        }
        return retorno;


    }

    @SuppressLint("Range")
    public List<Cliente> getAllClientes(String tabela){

        db = getWritableDatabase();

        List<Cliente> clientes = new ArrayList<>();
        Cliente obj;

        String sql = "SELECT * FROM "+tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql,null);

        if (cursor.moveToFirst()){

            do{
                obj = new Cliente();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                obj.setTelefone(cursor.getString(cursor.getColumnIndex(ClienteDataModel.TELEFONE)));
                obj.setIdade(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.IDADE)));

                clientes.add(obj);

                Log.i(AppUtil.TAG,"getAllCLiente : "+obj.getNome());

            }while (cursor.moveToNext());


        }



        return clientes;

    }

}
