import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] arr = path.split(" ");
            String dir = arr[0];

            for (int i = 1; i < arr.length; i++) {
                String str = arr[i];
                String[] file = str.replace(")", "(").split("\\(");
                String content = file[1];
                String fileName = file[0];

                List<String> files = map.getOrDefault(content, new ArrayList<String>());
                files.add(dir + "/" + fileName);
                map.put(content, files);
            }

        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> dupls : map.values()) {
            if (dupls.size() > 1) {
                res.add(dupls);
            }
        }

        return res;
    }
}
