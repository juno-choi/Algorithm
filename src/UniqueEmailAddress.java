import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

    public static void main(String[] args) {
        UniqueEmailAddress a = new UniqueEmailAddress();
        String[] emails = {"test.email+james@coding.com","test.e.mail+toto.jane@coding.com","testemail+tom@cod.ing.com"};
        System.out.println(a.solve(emails));
    }

    public int solve(String[] emails){
        //1 data structure
        //중복을 피해서 담기 위한 set
        Set<String> set = new HashSet<>();

        //for, while
        for(String email : emails){
            String localName = makeLocalName(email);    //@앞 testemail을 만듦
            String domainName = makeDomainName(email);  //@뒤

            String newEmail = localName+domainName;
            set.add(newEmail);
        }

        return set.size();
    }

    private String makeLocalName(String email){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<email.length(); i++){

            String str = String.valueOf(email.charAt(i));
            if(str.equals(".")){
                continue;
            }
            if(str.equals("+")){
                break;
            }
            if(str.equals("@")){
                break;
            }

            sb.append(str);
        }
        return sb.toString();
    }

    private String makeDomainName(String email){
        return email.substring(email.indexOf('@'));
    }




}
