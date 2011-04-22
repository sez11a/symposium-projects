create table talelets_Talelet (
	uuid_ VARCHAR(75) null,
	taleId LONG not null primary key,
	taleParentId LONG,
	taleStarterId LONG,
	taleOrder INTEGER,
	taleTitle VARCHAR(75) null,
	authorName VARCHAR(75) null,
	taleDate DATE null,
	dateUpdated DATE null,
	content TEXT null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);