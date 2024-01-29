package org.example.services;

import com.google.gson.Gson;
import org.example.domain.Person;

import java.io.*;

public class FileHandler {
    Gson gson = new Gson();
    public void savePersonToFile(Person person, String filePath) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        fileOutputStream.write(gson.toJson(person).getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

//    public Person loadPersonFromFile(String filePath) throws IOException, ClassNotFoundException {
//        String json = (String) new ObjectInputStream(new FileInputStream(new File(filePath))).readObject();
//        return gson.fromJson(json, Person.class);
//    }
    public Person loadPersonFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream inputStream = new FileInputStream(new File(filePath));
        StringBuilder stringBuilder = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String receiveString = "";
            while ((receiveString = bufferedReader.readLine()) != null){
                stringBuilder.append(receiveString);
            }
            inputStream.close();
        }
        String json = stringBuilder.toString();
        return gson.fromJson(json, Person.class);
    }
}
