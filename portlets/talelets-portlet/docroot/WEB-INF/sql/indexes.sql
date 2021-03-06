create index IX_5548B56E on talelets_Talelet (companyId);
create index IX_4EBBBF70 on talelets_Talelet (groupId);
create index IX_D8BB8E56 on talelets_Talelet (groupId, status);
create index IX_4DBBCA88 on talelets_Talelet (groupId, taleOrder);
create index IX_AEEB016E on talelets_Talelet (groupId, taleOrder, status);
create index IX_7A3AA7AA on talelets_Talelet (groupId, userId);
create index IX_84B5765A on talelets_Talelet (taleParent, taleOrder);
create index IX_6AF51FFF on talelets_Talelet (taleParentId, taleOrder);
create index IX_27CEEFE5 on talelets_Talelet (taleParentId, taleOrder, status);
create index IX_D20D0DFA on talelets_Talelet (taleStarterId);
create index IX_C39A6DFA on talelets_Talelet (uuid_);
create unique index IX_210E1FF0 on talelets_Talelet (uuid_, groupId);