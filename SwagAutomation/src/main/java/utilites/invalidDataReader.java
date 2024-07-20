package utilites;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;

public class invalidDataReader {
    public static Object[][] GetInValidLoginData() {
        String filePath = "src\\test\\Resources\\testdata\\invaliddata";
        Gson gson = new Gson();
        Object[][] data;

        try (FileReader reader = new FileReader(filePath)) {
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
            data = new Object[jsonArray.size()][2];

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                if (jsonObject.has("invalid username") && jsonObject.has("invalid password")) {
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
