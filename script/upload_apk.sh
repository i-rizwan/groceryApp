
#!/usr/bin/env bash

build_comment="This is latest android app apk"

#diawi_token=" "

#diawi_password="123456"

echo "----------------------**********TRAVIS_BUILD_DIR............$TRAVIS_BUILD_DIR"

upload_to_diawi () {
  # $1: file to upload an apk
  # $2: comment about app version/build
  jobInfos=$(curl https://upload.diawi.com/ -F token=$diawi_token \
-F file=@$android_file_name \
-F wall_of_apps=1 \
-F password=$diawi_password \
-F comment=$build_comment \
-F callback_url='http://www.myintranet.com/my-diawi-callback-url' \
-F callback_emails='rizwan.tasveen@gmail.com'
)
  echo "---------------------------------message--6---$jobInfos"

}

extract_apk_from_build_dir () {

  echo "-----Uploading on diawi starts---1--"
  echo "Uploading android apk------------2--"
  echo "$android_file_name---------------3--"

  find $TRAVIS_BUILD_DIR -type f -name "*.apk" -not -name ".DS_Store" -print0 | while read -r -d '' android_file_name
  do
  echo "$android_file_name---------------4--"
  echo "$build_comment-------------------5--"
  upload_to_diawi $android_file_name $build_comment

  done

  echo "Uploading on diawi ends----------8--"

 }

echo "----------------------********** DIAWI SCRIPT CALLED********************............"

extract_apk_from_build_dir