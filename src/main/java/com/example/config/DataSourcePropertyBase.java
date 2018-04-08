package com.example.config;

public class DataSourcePropertyBase implements Cloneable {
	/**  */
	private Boolean allowEncodingChanges;

	/**  */
	private String applicationName;

	/**  */
	private String assumeMinServerVersion;

	/**  */
	private Boolean binaryTransfer;

	/**  */
	private String binaryTransferDisable;

	/**  */
	private String binaryTransferEnable;

	/**  */
	private String charset;

	/**  */
	private String compatible;

	/**  */
	private Integer connectTimeout;

	/**  */
	private String currentSchema;

	/**  */
	private String databaseName;

	/**  */
	private Integer defaultRowFetchSize;

	/**  */
	private Boolean disableColumnSanitiser;

	/**  */
	private String gssLib;

	/**  */
	private Integer hostRecheckSeconds;

	/**  */
	private String jaasApplicationName;

	/**  */
	private String kerberosServerName;

	/**  */
	private Boolean loadBalanceHosts;

	/**  */
	private Integer loginTimeout;

	/**  */
	private Integer loglevel;

	/**  */
	private Integer logLevel;

	/**  */
	private Boolean logUnclosedConnections;
	
	/** */
	private String name;

	/**  */
	private String password;

	/**  */
	private Integer portNumber;

	/**  */
	private Integer preparedStatementCacheQueries;

	/**  */
	private Integer preparedStatementCacheSizeMiB;

	/**  */
	private Integer prepareThreshold;

	/**  */
	private Integer protocolVersion;

	/**  */
	private Boolean readOnly;

	/**  */
	private Integer receiveBufferSize;

	/**  */
	private Integer sendBufferSize;

	/**  */
	private String serverName;

	/**  */
	private String socketFactory;

	/**  */
	private String socketFactoryArg;

	/**  */
	private Integer socketTimeout;

	/**  */
	private Boolean ssl;

	/**  */
	private String sslCert;

	/**  */
	private String sslfactory;

	/**  */
	private String sslFactoryArg;

	/**  */
	private String sslHostnameVerifier;

	/**  */
	private String sslKey;

	/**  */
	private String sslMode;

	/**  */
	private String sslPassword;

	/**  */
	private String sslPasswordCallback;

	/**  */
	private String sslRootCert;

	/**  */
	private String sspiServiceClass;

	/**  */
	private String stringType;

	/**  */
	private String targetServerType;

	/**  */
	private Boolean tcpKeepAlive;

	/**  */
	private Integer unknownLength;

	/**  */
	private String url;

	/**  */
	private String user;

	/**  */
	private Boolean useSpNego;

	public Boolean getAllowEncodingChanges() {
		return allowEncodingChanges;
	}

	public void setAllowEncodingChanges(Boolean allowEncodingChanges) {
		this.allowEncodingChanges = allowEncodingChanges;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getAssumeMinServerVersion() {
		return assumeMinServerVersion;
	}

	public void setAssumeMinServerVersion(String assumeMinServerVersion) {
		this.assumeMinServerVersion = assumeMinServerVersion;
	}

	public Boolean getBinaryTransfer() {
		return binaryTransfer;
	}

	public void setBinaryTransfer(Boolean binaryTransfer) {
		this.binaryTransfer = binaryTransfer;
	}

	public String getBinaryTransferDisable() {
		return binaryTransferDisable;
	}

	public void setBinaryTransferDisable(String binaryTransferDisable) {
		this.binaryTransferDisable = binaryTransferDisable;
	}

	public String getBinaryTransferEnable() {
		return binaryTransferEnable;
	}

	public void setBinaryTransferEnable(String binaryTransferEnable) {
		this.binaryTransferEnable = binaryTransferEnable;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getCompatible() {
		return compatible;
	}

	public void setCompatible(String compatible) {
		this.compatible = compatible;
	}

	public Integer getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(Integer connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public String getCurrentSchema() {
		return currentSchema;
	}

	public void setCurrentSchema(String currentSchema) {
		this.currentSchema = currentSchema;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public Integer getDefaultRowFetchSize() {
		return defaultRowFetchSize;
	}

	public void setDefaultRowFetchSize(Integer defaultRowFetchSize) {
		this.defaultRowFetchSize = defaultRowFetchSize;
	}

	public Boolean getDisableColumnSanitiser() {
		return disableColumnSanitiser;
	}

	public void setDisableColumnSanitiser(Boolean disableColumnSanitiser) {
		this.disableColumnSanitiser = disableColumnSanitiser;
	}

	public String getGssLib() {
		return gssLib;
	}

	public void setGssLib(String gssLib) {
		this.gssLib = gssLib;
	}

	public Integer getHostRecheckSeconds() {
		return hostRecheckSeconds;
	}

	public void setHostRecheckSeconds(Integer hostRecheckSeconds) {
		this.hostRecheckSeconds = hostRecheckSeconds;
	}

	public String getJaasApplicationName() {
		return jaasApplicationName;
	}

	public void setJaasApplicationName(String jaasApplicationName) {
		this.jaasApplicationName = jaasApplicationName;
	}

	public String getKerberosServerName() {
		return kerberosServerName;
	}

	public void setKerberosServerName(String kerberosServerName) {
		this.kerberosServerName = kerberosServerName;
	}

	public Boolean getLoadBalanceHosts() {
		return loadBalanceHosts;
	}

	public void setLoadBalanceHosts(Boolean loadBalanceHosts) {
		this.loadBalanceHosts = loadBalanceHosts;
	}

	public Integer getLoginTimeout() {
		return loginTimeout;
	}

	public void setLoginTimeout(Integer loginTimeout) {
		this.loginTimeout = loginTimeout;
	}

	public Integer getLoglevel() {
		return loglevel;
	}

	public void setLoglevel(Integer loglevel) {
		this.loglevel = loglevel;
	}

	public Integer getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(Integer logLevel) {
		this.logLevel = logLevel;
	}

	public Boolean getLogUnclosedConnections() {
		return logUnclosedConnections;
	}

	public void setLogUnclosedConnections(Boolean logUnclosedConnections) {
		this.logUnclosedConnections = logUnclosedConnections;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(Integer portNumber) {
		this.portNumber = portNumber;
	}

	public Integer getPreparedStatementCacheQueries() {
		return preparedStatementCacheQueries;
	}

	public void setPreparedStatementCacheQueries(Integer preparedStatementCacheQueries) {
		this.preparedStatementCacheQueries = preparedStatementCacheQueries;
	}

	public Integer getPreparedStatementCacheSizeMiB() {
		return preparedStatementCacheSizeMiB;
	}

	public void setPreparedStatementCacheSizeMiB(Integer preparedStatementCacheSizeMiB) {
		this.preparedStatementCacheSizeMiB = preparedStatementCacheSizeMiB;
	}

	public Integer getPrepareThreshold() {
		return prepareThreshold;
	}

	public void setPrepareThreshold(Integer prepareThreshold) {
		this.prepareThreshold = prepareThreshold;
	}

	public Integer getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(Integer protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public Boolean getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(Boolean readOnly) {
		this.readOnly = readOnly;
	}

	public Integer getReceiveBufferSize() {
		return receiveBufferSize;
	}

	public void setReceiveBufferSize(Integer receiveBufferSize) {
		this.receiveBufferSize = receiveBufferSize;
	}

	public Integer getSendBufferSize() {
		return sendBufferSize;
	}

	public void setSendBufferSize(Integer sendBufferSize) {
		this.sendBufferSize = sendBufferSize;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getSocketFactory() {
		return socketFactory;
	}

	public void setSocketFactory(String socketFactory) {
		this.socketFactory = socketFactory;
	}

	public String getSocketFactoryArg() {
		return socketFactoryArg;
	}

	public void setSocketFactoryArg(String socketFactoryArg) {
		this.socketFactoryArg = socketFactoryArg;
	}

	public Integer getSocketTimeout() {
		return socketTimeout;
	}

	public void setSocketTimeout(Integer socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public Boolean getSsl() {
		return ssl;
	}

	public void setSsl(Boolean ssl) {
		this.ssl = ssl;
	}

	public String getSslCert() {
		return sslCert;
	}

	public void setSslCert(String sslCert) {
		this.sslCert = sslCert;
	}

	public String getSslfactory() {
		return sslfactory;
	}

	public void setSslfactory(String sslfactory) {
		this.sslfactory = sslfactory;
	}

	public String getSslFactoryArg() {
		return sslFactoryArg;
	}

	public void setSslFactoryArg(String sslFactoryArg) {
		this.sslFactoryArg = sslFactoryArg;
	}

	public String getSslHostnameVerifier() {
		return sslHostnameVerifier;
	}

	public void setSslHostnameVerifier(String sslHostnameVerifier) {
		this.sslHostnameVerifier = sslHostnameVerifier;
	}

	public String getSslKey() {
		return sslKey;
	}

	public void setSslKey(String sslKey) {
		this.sslKey = sslKey;
	}

	public String getSslMode() {
		return sslMode;
	}

	public void setSslMode(String sslMode) {
		this.sslMode = sslMode;
	}

	public String getSslPassword() {
		return sslPassword;
	}

	public void setSslPassword(String sslPassword) {
		this.sslPassword = sslPassword;
	}

	public String getSslPasswordCallback() {
		return sslPasswordCallback;
	}

	public void setSslPasswordCallback(String sslPasswordCallback) {
		this.sslPasswordCallback = sslPasswordCallback;
	}

	public String getSslRootCert() {
		return sslRootCert;
	}

	public void setSslRootCert(String sslRootCert) {
		this.sslRootCert = sslRootCert;
	}

	public String getSspiServiceClass() {
		return sspiServiceClass;
	}

	public void setSspiServiceClass(String sspiServiceClass) {
		this.sspiServiceClass = sspiServiceClass;
	}

	public String getStringType() {
		return stringType;
	}

	public void setStringType(String stringType) {
		this.stringType = stringType;
	}

	public String getTargetServerType() {
		return targetServerType;
	}

	public void setTargetServerType(String targetServerType) {
		this.targetServerType = targetServerType;
	}

	public Boolean getTcpKeepAlive() {
		return tcpKeepAlive;
	}

	public void setTcpKeepAlive(Boolean tcpKeepAlive) {
		this.tcpKeepAlive = tcpKeepAlive;
	}

	public Integer getUnknownLength() {
		return unknownLength;
	}

	public void setUnknownLength(Integer unknownLength) {
		this.unknownLength = unknownLength;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Boolean getUseSpNego() {
		return useSpNego;
	}

	public void setUseSpNego(Boolean useSpNego) {
		this.useSpNego = useSpNego;
	}
	
	@Override
	public DataSourcePropertyBase clone() {
		DataSourcePropertyBase cloned = null;
        /*Objectクラスのcloneメソ�?ド�?�CloneNotSupportedExceptionを投げる可能性がある�?�で、try-catch�?で記述(呼び出し�??に投げても良�?)*/
        try {
        	cloned = (DataSourcePropertyBase)super.clone(); //親クラスのcloneメソ�?ドを呼び出�?(親クラスの型で返ってくるので、�?��?自身の型でのキャストを忘れな�?ようにする)
        }catch (Exception e){
            e.printStackTrace();
        }
		return cloned;
	}

	
}
