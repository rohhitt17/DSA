class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ll= new ArrayList<>();
		paranthese(n,0,0,"",ll);
        return ll;
    }
    public static void paranthese(int n,int open,int close,String ans,List<String>ll) {
		if(open==n&&close==n) {
			ll.add(ans);
			return ;
		}
		if(open>n||close>open) {
			return;
		}
		paranthese(n,open+1,close,ans+"(",ll);
		paranthese(n,open,close+1,ans+")",ll);
    }
}