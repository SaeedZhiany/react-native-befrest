require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "ReactNativeBefrest"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.description  = <<-DESC
                  ReactNativeBefrest
                   DESC
  s.homepage     = "https://github.com/SaeedZhiany/react-native-befrest"
  s.license      = "MIT"
  # s.license    = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author       = { "author" => "developer.saeedzhiany@gmail.com" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/SaeedZhiany/react-native-befrest.git", :tag => "#{s.version}" }

  s.source_files = "ios/**/*.{h,m}"
  s.requires_arc = true

  s.dependency "React"
  #s.dependency "others"
end

