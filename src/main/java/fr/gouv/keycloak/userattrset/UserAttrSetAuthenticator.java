package fr.gouv.keycloak.userattrset;

import org.keycloak.authentication.Authenticator;

import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.models.AuthenticatorConfigModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.services.ServicesLogger;

public class UserAttrSetAuthenticator implements Authenticator {
    
    // logger using keyloak.services.ServicesLogger
    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    String Module = "userattrset : ";
    
    @Override
    public void authenticate(AuthenticationFlowContext context)
    {
        // Get Extension Parameters
        AuthenticatorConfigModel config = context.getAuthenticatorConfig();
        //
        String UserAttrName = config.getConfig().get(UserAttrSetConstants.CONF_USER_ATTR_NAME);
        String UserAttrValue = config.getConfig().get(UserAttrSetConstants.CONF_USER_ATTR_VALUE);
        //Get Session
        KeycloakSession Session = context.getSession();

        Session.setAttribute(UserAttrName, UserAttrValue);

        logger.debug(Module+"UserAttrName="+UserAttrName);
        logger.debug(Module+"UserAttrValue="+UserAttrValue);
    }

    
    @Override
    public boolean requiresUser()
    {
        return false;
    }

    @Override
    public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user)
    {
        return true;
    }

    @Override
    public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user)
    {
        // not needed for current version
    }

    @Override
    public void close()
    {
        // not used for current version
    }


    @Override
    public void action(AuthenticationFlowContext context) {
        // TODO Auto-generated method stub
        
    }

}