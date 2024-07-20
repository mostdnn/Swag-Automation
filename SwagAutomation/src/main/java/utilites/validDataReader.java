package utilites;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;

public class validDataReader {
    public static Object[][] GetValidLoginData() {
        String filePath = "src\\test\\Resources\\testdata\\validdata.json file";
        Gson gson = new Gson();
        Object[][] data;

        try (FileReader reader = new FileReader(filePath)) {
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
            data = new Object[jsonArray.size()][2];

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                if (jsonObject.has("username") && jsonObject.has("password")) {
                    data[i][0] = jsonObject.get("username").getAsString();
                    data[i][1] = jsonObject.get("password").getAsString();
                } else {
                    data[i][0] = jsonObject.get("invalid username").getAsString();
                    data[i][1] = jsonObject.get("invalid password").getAsString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new Object[0][0];
        }

        return data;
    }
}