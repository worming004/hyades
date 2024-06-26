#!/usr/bin/env bash

# This file is part of Dependency-Track.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# SPDX-License-Identifier: Apache-2.0
# Copyright (c) OWASP Foundation. All Rights Reserved.

set -euo pipefail

DEFAULT_API_URL='http://localhost:8080'
DEFAULT_USERNAME='admin'
DEFAULT_OLD_PASSWORD='admin'
DEFAULT_NEW_PASSWORD='admin123'

function print_help() {
  echo "Change a user's password"
  echo ""
  echo "Usage: $0 [-a <API_URL>] [-u <USERNAME>] [-p <PASSWORD>] [-n <NEW_PASSWORD>]"
  echo "Options:"
  echo " -a   Set Dependency-Track API URL (default: ${DEFAULT_API_URL})"
  echo " -u   Set username                 (default: ${DEFAULT_USERNAME})"
  echo " -p   Set current password         (default: ${DEFAULT_OLD_PASSWORD})"
  echo " -n   Set new password             (default: ${DEFAULT_NEW_PASSWORD})"
  echo ""
}

while getopts ":h:a:u:p:" opt; do
  case $opt in
    a)
      api_url=$OPTARG
      ;;
    u)
      username=$OPTARG
      ;;
    p)
      old_password=$OPTARG
      ;;
    n)
      new_password=$OPTARG
      ;;
    h)
      print_help
      exit
      ;;
    *)
      print_help
      exit
      ;;
  esac
done

echo "[+] Changing password for user ${username:-$DEFAULT_USERNAME}"
curl "${api_url:-$DEFAULT_API_URL}/api/v1/user/forceChangePassword" \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -d "username=${username:-$DEFAULT_USERNAME}&password=${old_password:-$DEFAULT_OLD_PASSWORD}&newPassword=${new_password:-$DEFAULT_NEW_PASSWORD}&confirmPassword=${new_password:-$DEFAULT_NEW_PASSWORD}"
