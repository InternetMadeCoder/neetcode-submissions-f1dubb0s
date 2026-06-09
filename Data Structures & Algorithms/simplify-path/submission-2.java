class Solution {
    public String simplifyPath(String path) {
        Stack<String> dir = new Stack<>();
        String[] parts = path.split("/");

        for(String part : parts) {
            if(part.equals("") || part.equals(".")) { // ignore and continue
                continue;
            }
            if(part.equals("..")) { // pop from the stack -> go back to parent dir
                if(!dir.isEmpty()) dir.pop();
            }
            else {
                dir.push(part);
            }
        }

        StringBuilder result = new StringBuilder();
        for(String d : dir) {
            result.append("/").append(d);
        }
        return (dir.isEmpty()) ? "/" : result.toString(); // convert to string
    }
}