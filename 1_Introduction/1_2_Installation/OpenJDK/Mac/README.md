# OpenJDK 설치 방법 (Mac)

## HomeBrew 설치

```zsh
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

참고: [HomeBrew 홈페이지](https://brew.sh)

## OpenJDK 저장소 추가

```zsh
brew tap AdoptOpenJDK/openjdk
```

## OpenJDK 설치

```zsh
brew cask install adoptopenjdk13
```

## 설치 확인

```zsh
java -version
```
