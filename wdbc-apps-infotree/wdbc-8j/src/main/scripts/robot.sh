# JDK version 1.5 is required. However, it does not work on JDK 1.6.
# Following system properties are supported by this robot:
#    -Dcategory            Category id to be fetched from. Default value is "bkg".
#    -Dcategory.infotree   Which category id of InfoTree.com to store data to. Default value is "628".
#    -Dcity                City code in the URL. Default value is "sh".
#    -DmaxDays             How many days of data to be fetched. Default value is "3".
#    -DmaxPages            How many pages of data to be fetched. Default value is "2".
#    -Daction              Which URL will message post to. Default value is "http://www.xiaoxishu.com/XSpiderRobot".
#    -Dpassword            Which password will be used to list message. Default value is "a123456".
#    -Dusername            Which username will be used to list message. Default value is "perry111701".

java -Dcategory=bkg -Dcategory.infotree=628 -Dcity=sh -jar wdbc-8j.jar