create table insults_Insult (
	insultId LONG not null primary key,
	adjectiveOne VARCHAR(75) null,
	directObject VARCHAR(75) null,
	adjectiveTwo VARCHAR(75) null,
	objPreposition VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	userId LONG
);