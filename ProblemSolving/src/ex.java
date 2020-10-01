public class ex {
    public static void main(String[] args) {
        System.out.println(makeCommand("UP", 3));

    }

    private static String makeCommand(String action, int id) {
        String command;
        if (action.equals("ENTER") || action.equals("EXIT")) {
            command = "{\"commands\":[{\"elevator_id\":0,\"command\" : \"" + action + "\",\"call_ids\" : [" + id + "]}]}";
        } else {
            command = "{\"commands\":[{\"elevator_id\":0,\"command\" : \"" + action + "\"}]}";
        }
        return command;
    }
}
