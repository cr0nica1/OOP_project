import java.util.HashMap;

public class SpecialEffect {
    // HashMap lưu trữ hiệu ứng với key là tên hiệu ứng và value là mảng chứa damage và duration
    private static final HashMap<String, double[]> effects = new HashMap<>();

    static {
        // Thêm sẵn một số hiệu ứng đặc biệt
        effects.put("Fire Burst", new double[]{30, 5.0});
        effects.put("Explosion", new double[]{50, 2.5});
        effects.put("Burn", new double[]{50, 5.0});
    }

    // Lấy damage của hiệu ứng dựa vào tên
    public static int getEffectDamage(String effectName) {
        if (effects.containsKey(effectName)) {
            return (int) effects.get(effectName)[0];
        }
        return 0;
    }

    // Lấy duration của hiệu ứng dựa vào tên
    public static double getEffectDuration(String effectName) {
        if (effects.containsKey(effectName)) {
            return effects.get(effectName)[1];
        }
        return 0.0;
    }

    // Trả về chi tiết của hiệu ứng
    public static String getEffectDetails(String effectName) {
        if (effects.containsKey(effectName)) {
            double[] values = effects.get(effectName);
            return effectName + " + " + (int) values[0] + " damage, Duration: " + values[1] + "s";
        }
        return "No special effect";
    }
}
