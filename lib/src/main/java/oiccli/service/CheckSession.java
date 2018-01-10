package oiccli.service;

import com.auth0.jwt.creators.Message;
import oiccli.client_info.ClientInfo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckSession extends Service {
    private static CheckSessionRequest checkSessionRequest;
    private static Message message;
    private static ErrorResponse errorResponse;
    private static String endpointName = "";
    private static boolean isSynchronous = true;
    private static String request = "checkSession";

    public CheckSession(String httpLib, KeyJar keyJar, String clientAuthenticationMethod) {
        super(httpLib, keyJar, clientAuthenticationMethod);
        //self.pre_construct = [self.oic_pre_construct]
    }

    public List<Map<String, String>> oicPreConstruct(ClientInfo clientInfo, Map<String, String> requestArgs, Map<String, String> args) {
        requestArgs = UserInfo.setIdToken(clientInfo, requestArgs, args);
        return Arrays.asList(requestArgs, new HashMap<String, String>());
    }

}
