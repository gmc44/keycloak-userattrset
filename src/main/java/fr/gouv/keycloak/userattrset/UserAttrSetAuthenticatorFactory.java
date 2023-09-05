package fr.gouv.keycloak.userattrset;

import java.util.ArrayList;
import java.util.List;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

public class UserAttrSetAuthenticatorFactory
    implements AuthenticatorFactory
{

    public static final String ID = "keycloak-userattrset";

    private static final AuthenticationExecutionModel.Requirement[] REQUIREMENT_CHOICES = {
            AuthenticationExecutionModel.Requirement.REQUIRED,
            AuthenticationExecutionModel.Requirement.ALTERNATIVE,
            AuthenticationExecutionModel.Requirement.DISABLED
    };

    private static final List<ProviderConfigProperty> configProperties = new ArrayList<ProviderConfigProperty>();

    static {
        ProviderConfigProperty property;
        //API
        property = new ProviderConfigProperty();
        property.setName(UserAttrSetConstants.CONF_USER_ATTR_NAME);
        property.setLabel("User Attr Name");
        property.setType(ProviderConfigProperty.STRING_TYPE);
        property.setHelpText("Enter User Attr Name to set");
        configProperties.add(property);
        property = new ProviderConfigProperty();
        property.setName(UserAttrSetConstants.CONF_USER_ATTR_VALUE);
        property.setLabel("User Attr Value");
        property.setType(ProviderConfigProperty.STRING_TYPE);
        property.setHelpText("Enter User Attr Value");
        configProperties.add(property);
    }

    @Override
    public Authenticator create(KeycloakSession session)
    {
        return new UserAttrSetAuthenticator();
    }

    @Override
    public String getId()
    {
        return ID;
    }

    @Override
    public String getReferenceCategory()
    {
        return "UserAttrSet";
    }

    @Override
    public boolean isConfigurable()
    {
        // return false;
        return true;
    }

    @Override
    public boolean isUserSetupAllowed()
    {
        return true;
    }

    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices()
    {
        return REQUIREMENT_CHOICES;
    }

    @Override
    public String getDisplayType()
    {
        return "User Attr Set";
    }

    @Override
    public String getHelpText()
    {
        return "User Attr Set";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return configProperties;
    }

    @Override
    public void init(Config.Scope config)
    {
        // not needed for current version
    }

    @Override
    public void postInit(KeycloakSessionFactory factory)
    {
        // not needed for current version
    }

    @Override
    public void close()
    {
        // not used for current version
    }

}