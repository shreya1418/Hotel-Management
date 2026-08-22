package com.example.hotelmanagement;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class MemoryData {


    public static void savedName(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("nameee.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void savedPhone(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("phonee.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void savedRoomType(String RoomType ,  Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("RoomTypee.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(RoomType.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void savedCheck_in_time(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("Check_in_timee.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void savedCheck_out_time(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("Check_out_timee.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void savedCheck_in_date(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("Check_in_datee.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void savedCheck_out_date(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("Check_out_datee.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void savedToken(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("Tokenn.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void savedAmount(String data , Context context){
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("amount.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    //

    public static String getName(Context context){
        String data = "";
        try {
            FileInputStream fis = context.openFileInput("nameee.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            data = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    public static String getPhone(Context context){
        String data = "";
        try {
            FileInputStream fis = context.openFileInput("phonee.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            data = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    public static String getRoomType(Context context){
        String RoomType = "";
        try {
            FileInputStream fis = context.openFileInput("RoomTypee.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            RoomType = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return RoomType;
    }

    public static String getCheck_in_time(Context context){
        String RoomType = "";
        try {
            FileInputStream fis = context.openFileInput("Check_in_timee.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            RoomType = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return RoomType;
    }

    public static String getCheck_out_time(Context context){
        String RoomType = "";
        try {
            FileInputStream fis = context.openFileInput("Check_out_timee.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            RoomType = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return RoomType;
    }

    public static String getCheck_in_date(Context context){
        String RoomType = "";
        try {
            FileInputStream fis = context.openFileInput("Check_in_datee.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            RoomType = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return RoomType;
    }

    public static String getCheck_out_date(Context context){
        String RoomType = "";
        try {
            FileInputStream fis = context.openFileInput("Check_out_datee.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            RoomType = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return RoomType;
    }

    public static String getToken(Context context){
        String RoomType = "";
        try {
            FileInputStream fis = context.openFileInput("Tokenn.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            RoomType = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return RoomType;
    }

    public static String getAmount(Context context){
        String amount = "";
        try {
            FileInputStream fis = context.openFileInput("amount.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                sb.append(line);
            }
            amount = sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return amount;
    }

    //

}
