package io.scalajs.nodejs.path

import org.scalatest.FunSpec

/**
  * Path Tests
  * @author lawrence.daniels@gmail.com
  */
class PathTest extends FunSpec {

  describe("Path") {

    it("supports basename()") {
      assert(Path.basename("/foo/bar/baz/asdf/quux.html") == "quux.html")
      assert(Path.basename("/foo/bar/baz/asdf/quux.html", ".html") == "quux")
    }

    it("supports posix.basename()") {
      assert(Path.posix.basename("C:\\temp\\data.txt") == "C:\\temp\\data.txt")
      assert(Path.posix.basename("/temp/data.txt") == "data.txt")
    }

    it("supports win32.basename()") {
      assert(Path.win32.basename("C:\\temp\\data.txt") == "data.txt")
      assert(Path.win32.basename("/temp/data.txt") == "data.txt")
    }

    it("supports format()") {
      assert(Path.format(new PathObject(root = "/", base = "file.txt")) == "/file.txt")
    }

    it("supports isAbsolute()") {
      assert(Path.isAbsolute("/foo/bar"))
      assert(Path.isAbsolute("/baz/.."))
      assert(!Path.isAbsolute("qux/"))
      assert(!Path.isAbsolute("."))
    }

    it("supports join()") {
      Path.join("/foo", "bar", "baz/asdf", "quux", "..") == "/foo/bar/baz/asdf"
    }

  }
}
